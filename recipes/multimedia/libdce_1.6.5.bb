SUMMARY = "libdce"
SECTION = "multimedia"
LICENSE = "TI"
LIC_FILES_CHKSUM = "file://COPYING;md5=483f94bdaf5d31cd94aa2317f9ad2684"

DEPENDS = "libdrm wayland"

inherit autotools lib_package

PV = "1.6.5"
PR = "r2"
PR_append = "+gitr${SRCREV}"

SRCREV = "0c0ed32efd7569d2c65a4946c56150a344a63c5b"
SRC_URI = "git://gitorious.org/gstreamer-omap/libdce.git;protocol=git"

S = "${WORKDIR}/git"

#do_install_append() {
#	install -d ${D}${base_libdir}/firmware
#	install -m 0644 firmware/* ${D}${base_libdir}/firmware/
#}

#FILES_${PN} += "${base_libdir}/firmware/"
