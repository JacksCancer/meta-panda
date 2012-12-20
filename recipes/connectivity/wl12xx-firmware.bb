LICENSE = "proprietary-binary"
LIC_FILES_CHKSUM = "file://LICENCE;md5=ba590e1d103f891d0151609046aef9e8"

PR = "r2"

SRCREV = "bd57d0400adefe4091a91bdf765bc14210f888c0"
SRC_URI = " \
    git://github.com/TI-OpenLink/firmwares.git;protocol=git \
    file://wl1271-nvs.bin"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/lib/firmware/ti-connectivity/
    install -m 0644 ${S}/*.bin ${D}/lib/firmware/ti-connectivity/
    install -m 0644 ${WORKDIR}/*.bin ${D}/lib/firmware/ti-connectivity/
}

FILES_${PN} += "/lib/firmware/ti-connectivity/*"


