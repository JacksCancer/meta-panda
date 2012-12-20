LICENSE = "OMAPCONF"
LIC_FILES_CHKSUM = "file://LICENSE;md5=205c83c4e2242a765acb923fc766e914"

PR = "r1"
PV = "1.61.1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://tiomapconf_${PV}.orig.tar.gz"

S = "${WORKDIR}/tiomapconf-${PV}"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX} DESTDIR=${D}${sbindir}"

do_compile() {
    oe_runmake omapconf
}

do_install() {
    oe_runmake install
}
