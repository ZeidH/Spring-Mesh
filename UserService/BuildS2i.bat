IF EXIST "target" RMDIR /S /Q "target"
s2i build . registry.access.redhat.com/ubi8/openjdk-11 user-service -e GC_MAX_METASPACE_SIZE=2000 -e AB_JOLOKIA_OFF=true -c --incremental