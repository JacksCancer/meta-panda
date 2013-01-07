LICENSE = "proprietary-binary"
LIC_FILES_CHKSUM = "file://license.txt;md5=a9b2fa6b5a8bd374764f60b71cb550a6"

PV = "1.9.0.7.1.4"
PR = "r3"

SRC_URI = "file://pvr-omap4_${PV}.orig.tar.gz \
	file://pkgconfig-wayland-egl.patch \
	"

PROVIDES = "virtual/libgles1 virtual/libgles2 virtual/egl wayland-egl"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/usr
    cp -ar ${S}/usr/* ${D}/usr
    cp --remove-destination -H ${S}/usr/lib/gbm/gbm_pvr.so ${D}/usr/lib/gbm/
}

FILES_${PN} += "/usr/lib/gbm/*.so*"
FILES_${PN}-dbg += "/usr/lib/debug/*"
