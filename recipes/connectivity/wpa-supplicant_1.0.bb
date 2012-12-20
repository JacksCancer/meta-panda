DESCRIPTION = "A Client for Wi-Fi Protected Access (WPA)."
HOMEPAGE = "http://hostap.epitest.fi/wpa_supplicant/"
BUGTRACKER = "http://hostap.epitest.fi/bugz/"
SECTION = "network"
LICENSE = "GPLv2 | BSD"
LIC_FILES_CHKSUM = "file://../COPYING;md5=c54ce9345727175ff66d17b67ff51f58 \
                    file://../README;md5=9bee93996fecdb70f807baceb29d84b9 \
                    file://wpa_supplicant.c;beginline=1;endline=17;md5=372fb65dc23b228aec4e40e64de3e467"
                    
DEPENDS = "openssl libnl"
                    
SRC_URI = " \
    http://hostap.epitest.fi/releases/wpa_supplicant-${PV}.tar.gz \
    file://defconfig \
"

S = "${WORKDIR}/wpa_supplicant-${PV}/wpa_supplicant"

export BINDIR = "${sbindir}"
export LIBDIR = "${libdir}"

do_configure () {
	install -m 0755 ${WORKDIR}/defconfig .config
}

do_compile () {
	unset CFLAGS CPPFLAGS CXXFLAGS
	oe_runmake
}

do_install () {
    oe_runmake DESTDIR=${D} install
}

