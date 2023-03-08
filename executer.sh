#!/bin/bash

hosts=$(seq 1 22)
lab=(xgrid)

echo $@

for h in ${lab[@]}; do
    echo $h
    for i in $hosts; do
        echo "--------------------"
        echo "host $h$i"
        sshpass -p swarch ssh swarch@$h$i $@
        echo "--------------------"
        echo ""
    done
done

