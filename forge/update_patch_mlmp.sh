rm modLoaderMP.patch
touch modLoaderMP.patch

diff -u ../src_base ../src_work -r --strip-trailing-cr | tr -d '\r' \
      >> modLoaderMP.patch
