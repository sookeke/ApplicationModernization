#!/bin/bash

SCRIPT_FOLDER="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
PROJECT_FOLDER="$(cd $SCRIPT_FOLDER; cd ..; pwd )"

exec 3>&1

function _out() {
  echo "$(date +'%F %H:%M:%S') $@"
}

function setup() {
  _out Deploying storefront-mf-order
  
  _out Cleanup
  rm -rf ${PROJECT_FOLDER}/frontend-single-spa/order/dist
  rm -rf ${PROJECT_FOLDER}/frontend-single-spa/order/node_modules
  cd ${PROJECT_FOLDER}/frontend-single-spa/order
  oc delete -f deployment/kubernetes.yaml --ignore-not-found
  oc delete route storefront-mf-order --ignore-not-found
  oc delete is build-storefront-mf-order --ignore-not-found
  oc delete bc/build-storefront-mf-order --ignore-not-found
  
  ROUTE_MONOLITH=$(oc get route monolith-open-liberty-cloud-native -n app-mod-dev --template='{{ .spec.host }}')
  ROUTE_CATALOG=$(oc get route service-catalog-quarkus-reactive -n app-mod-dev --template='{{ .spec.host }}')
  if [ -z "$ROUTE_CATALOG" ]; then
    _out service-catalog-quarkus-reactive is not available. Run the command: \"sh scripts-openshift/deploy-service-catalog-quarkus-reactive.sh\"
  else 
    if [ -z "$ROUTE_MONOLITH" ]; then
      _out monolith-open-liberty-cloud-native is not available. Run the command: \"sh scripts-openshift/deploy-monolith-open-liberty-cloud-native.sh\"
    else 
      cd ${PROJECT_FOLDER}/frontend-single-spa/order
      cp Dockerfile Dockerfile.temp
      rm Dockerfile
      cp Dockerfile.os4 Dockerfile
      
      oc project app-mod-dev  > /dev/null 2>&1
      if [ $? != 0 ]; then 
          oc new-project app-mod-dev
      fi
      
      cp ${PROJECT_FOLDER}/frontend-single-spa/order/src/App.vue ${PROJECT_FOLDER}/frontend-single-spa/order/App.vue
      rm ${PROJECT_FOLDER}/frontend-single-spa/order/src/App.vue
      sed "s/http:\/\/localhost\/CustomerOrderServicesWeb\/jaxrs\/Customer\/OpenOrder\/LineItem/http:\/\/${ROUTE_MONOLITH}\/CustomerOrderServicesWeb\/jaxrs\/Customer\/OpenOrder\/LineItem/g" ${PROJECT_FOLDER}/frontend-single-spa/order/App.vue > ${PROJECT_FOLDER}/frontend-single-spa/order/src/App.vue
      
      cp ${PROJECT_FOLDER}/frontend-single-spa/order/src/components/Home.vue ${PROJECT_FOLDER}/frontend-single-spa/order/Home.vue
      rm ${PROJECT_FOLDER}/frontend-single-spa/order/src/components/Home.vue
      sed "s/http:\/\/localhost\/CustomerOrderServicesWeb\/jaxrs\/Customer\/Orders/http:\/\/${ROUTE_MONOLITH}\/CustomerOrderServicesWeb\/jaxrs\/Customer\/Orders/g" ${PROJECT_FOLDER}/frontend-single-spa/order/Home.vue > ${PROJECT_FOLDER}/frontend-single-spa/order/src/components/Home.vue
      
      cd ${PROJECT_FOLDER}/frontend-single-spa/order
      oc new-build --name build-storefront-mf-order --binary --strategy=docker
      oc start-build build-storefront-mf-order --from-dir=. --follow
      
      oc apply -f deployment/kubernetes.yaml
      oc expose svc/storefront-mf-order

      cd ${PROJECT_FOLDER}/frontend-single-spa/order
      rm Dockerfile
      cp Dockerfile.temp Dockerfile
      rm Dockerfile.temp

      rm ${PROJECT_FOLDER}/frontend-single-spa/order/src/App.vue
      cp ${PROJECT_FOLDER}/frontend-single-spa/order/App.vue ${PROJECT_FOLDER}/frontend-single-spa/order/src/App.vue
      rm ${PROJECT_FOLDER}/frontend-single-spa/order/App.vue

      rm ${PROJECT_FOLDER}/frontend-single-spa/order/src/components/Home.vue
      cp ${PROJECT_FOLDER}/frontend-single-spa/order/Home.vue ${PROJECT_FOLDER}/frontend-single-spa/order/src/components/Home.vue
      rm ${PROJECT_FOLDER}/frontend-single-spa/order/Home.vue
      
      _out Done deploying storefront-mf-order
      ROUTE=$(oc get route storefront-mf-order -n app-mod-dev --template='{{ .spec.host }}')
      _out Wait until the pod has been started: "oc get pod --watch | grep storefront-mf-order"
      
      _out "app.js:"
      _out "http://${ROUTE}/js/app.js"
    fi
  fi
}

setup