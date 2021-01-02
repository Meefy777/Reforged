rm minecraft.patch
touch minecraft.patch

diff -urN ../src_base ../src_work -r --strip-trailing-cr | tr -d '\r' \
      >> minecraft.patch
