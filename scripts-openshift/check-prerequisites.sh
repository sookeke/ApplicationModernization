#!/bin/bash

SCRIPT_FOLDER="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
PROJECT_FOLDER="$(cd $SCRIPT_FOLDER; cd ..; pwd )"

exec 3>&1

function _out() {
  echo "$(date +'%F %H:%M:%S') $@"
}

function checkPrerequisites() {
    MISSING_TOOLS=""
    git --version &> /dev/null || MISSING_TOOLS="${MISSING_TOOLS} git"
    curl --version &> /dev/null || MISSING_TOOLS="${MISSING_TOOLS} curl"
    which sed &> /dev/null || MISSING_TOOLS="${MISSING_TOOLS} sed"
    docker -v &> /dev/null || MISSING_TOOLS="${MISSING_TOOLS} docker"
    which oc &> /dev/null || MISSING_TOOLS="${MISSING_TOOLS} oc"
    if [[ -n "$MISSING_TOOLS" ]]; then
      _out "Some tools (${MISSING_TOOLS# }) could not be found, please install them first"
      exit 1
    else
      _out You have all necessary prerequisites installed
    fi
}

checkPrerequisites
