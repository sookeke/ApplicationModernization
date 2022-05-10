#!/bin/bash

SCRIPT_FOLDER="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
PROJECT_FOLDER="$(cd $SCRIPT_FOLDER; cd ..; pwd )"

exec 3>&1

function _out() {
  echo "$(date +'%F %H:%M:%S') $@"
}

function setup() {
  _out Installing Db2
  
  oc project 5b7aa5-dev  > /dev/null 2>&1
  if [ $? != 0 ]; then 
      oc new-project 5b7aa5-dev
  fi
    
  oc adm policy add-scc-to-user anyuid -z 5b7aa5-dev
  oc adm policy add-scc-to-user anyuid -z default

  oc create sa mysvcacct
  oc adm policy add-scc-to-user anyuid -z mysvcacct -n 5b7aa5-dev
  oc adm policy add-scc-to-user privileged -z default -n 5b7aa5-dev
  oc adm policy add-scc-to-user privileged -z mysvcacct -n 5b7aa5-dev
  oc apply -f ${PROJECT_FOLDER}/db2/deployment/db2-dc.yaml -n 5b7aa5-dev 
  oc apply -f ${PROJECT_FOLDER}/db2/deployment/db2-service.yaml -n 5b7aa5-dev 

  oc expose svc/storefront-db2 --port=50000
   
  _out Done installing Db2
  _out Wait until the pods have been started
  _out Run this command \(potentially multiple times\): \"oc wait db2/storefront-db2 --for=condition=Ready --timeout=300s -n 5b7aa5-dev\"
  _out After this run \"sh scripts-openshift/show-urls.sh\" to get the Db2 configuration
}

setup

