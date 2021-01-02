cd ..

rmdir /S /Q src
mkdir src
xcopy  /Y /E src_work\* src\

xcopy /Y /E forge\forge_client\src\* src\minecraft\
xcopy /Y /E forge\forge_common\* src\minecraft\
xcopy /Y /E forge\forge_server\src\* src\minecraft_server\
xcopy /Y /E forge\forge_common\* src\minecraft_server\

cmd /C recompile.bat
