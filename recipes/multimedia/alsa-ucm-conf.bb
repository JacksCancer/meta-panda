DESCRIPTION = "ALSA UCM Configuration Files"
SECTION = "console/utils"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = " \
    file://Panda.conf \
    file://hifi \
    file://hifiLP \
    "

S = "${WORKDIR}"

do_install() {

    install -d ${D}/usr/share/alsa/ucm/Panda
    cp \
        ${S}/Panda.conf \
        ${S}/hifi \
        ${S}/hifiLP \
        ${D}/usr/share/alsa/ucm/Panda
}

FILES_${PN} += "/usr/share/alsa/ucm/*"
