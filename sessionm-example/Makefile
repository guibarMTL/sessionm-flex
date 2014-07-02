# Build Main.swf and SessionmAirExample #

## Configuration
CONFIG_FILE = ../Makefile.config
include $(CONFIG_FILE)

## Build rules and recipes
iPhone: Main.swf
	cd src/main/flex
	$(AIR-SDK)/bin/adt -package -target ipa-test -keystore $(CERTIFICATE) \
	-storetype pkcs12 -provisioning-profile $(PROVISION) \
	../build/SessionmAirExample.ipa src/main/resources/app-descriptor.xml \
	Main.swf -extdir ../build

android: Main.swf
	cd src/main/flex
	$(AIR-SDK)/bin/adt -package -target apk-debug -keystore $(CERTIFICATE) \
	-storetype pkcs12 ../build/SessionmAirExample.apk src/main/resources/app-descriptor.xml \
	Main.swf -extdir ../build

Main.swf: 
	cd src/main/flex
	$(AIR-SDK)/bin/amxmlc src/main/flex/Main.as -include-libraries=../build/sessionm.ane \
	-output Main.swf

clean:
	rm -f Main.swf




