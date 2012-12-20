DESCRIPTION = "Software Development Kit"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY = "1"

PR = "r1"

PACKAGES = "${PN} ${PN}-dbg"

RPROVIDES_${PN} += "task-panda-standalone-sdk-target"

RDEPENDS_${PN} = "\
    packagegroup-core-standalone-sdk-target \
    libdrm-dev \
    libdce-dev \
    openssl-dev \
    libnl-dev \
    "
