#!/bin/sh
set -e
echo "building agent"
cd agent && mvn clean package
echo "building CDK"
cd ../cdk && mvn clean package && cdk deploy --all --require-approval=never