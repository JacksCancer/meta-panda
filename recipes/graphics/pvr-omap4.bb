LICENSE = "proprietary-binary"
LIC_FILES_CHKSUM = "file://license.txt;md5=a9b2fa6b5a8bd374764f60b71cb550a6"

PV = "1.9.0.7.1.4"

SRC_URI = "file://pvr-omap4_${PV}.orig.tar.gz"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/usr
    cp -ar ${S}/usr/* ${D}/usr
}


