rm mlprop.patch
touch mlprop.patch

diff -u ../src_base ../src_work -r --strip-trailing-cr | tr -d '\r' \
      >> mlprop.patch
