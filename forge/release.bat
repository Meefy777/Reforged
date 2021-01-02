cmd /C build.bat

cd ..

cmd /C reobfuscate.bat

cd forge

sh package.sh 1.0.7

pause
