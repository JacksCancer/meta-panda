SUMMARY = "libdce"
SECTION = "multimedia"
LICENSE = "TI"
LIC_FILES_CHKSUM = "file://COPYING;md5=483f94bdaf5d31cd94aa2317f9ad2684"

DEPENDS = "libdrm wayland"

inherit autotools lib_package

PV = "1.6.7"
PR = "r3"
PR_append = "+gitr${SRCREV}"

SRCREV = "ee4f5fd145de23fb00ee61a4f98dc4f8ae7d812e"
SRC_URI = "git://gitorious.org/gstreamer-omap/libdce.git;protocol=git"

S = "${WORKDIR}/git"

#do_install_append() {
#	install -d ${D}${base_libdir}/firmware
#	install -m 0644 firmware/* ${D}${base_libdir}/firmware/
#}

#FILES_${PN} += "${base_libdir}/firmware/"
