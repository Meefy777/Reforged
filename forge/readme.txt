Set up an MCP 4.3 folder with the update fix and install 
ModLoader and ModLoaderMP into minecraft.jar, and
install VERSION 1 of ModLoaderMP into minecraft_server.jar

VERSION 1 IS VERY IMPORTANT! Version 2 seems to be broken on
mcarchive, and the compilation patch is only made for version 1.

Copy the forge foler to your mcp folder, so it looks like this:
mcp/forge

Run setup.bat. If you did everything correctly then everything
should be succesful, and MCP should compile successfuly for both
client and server at the end of the setup program.


To setup an eclipse workspace:
Open the eclipse folder
Remove Client and Server
Click import projects
Select the forge folder
Import all projects

NOTE: You cannot run the minecraft client or server through this eclipse workspace.


To build and run:
Run build.bat
Run runclient.bat or runserver.bat in the MCP folder

After you have built, you can also reobfuscate and make a release.


To update the patch, you must have cygwin installed, or a tool that
adds diff and sh.
Run update_patch.bat or update_patch.sh, and minecraft.patch will
be updated.