SUMMARY = "KMSCON"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=7b09c62eae0d1148fb579f810f85e897"

inherit autotools pkgconfig

DEPENDS = "libxkbcommon libdrm udev freetype fontconfig"

PR = "r1"

SRCREV = "a67f02cf215a80ee97bfc23480f4c506cd9b8e7f"
SRC_URI = "git://github.com/dvdhrm/kmscon.git;protocol=git"

S = "${WORKDIR}/git"

EXTRA_OECONF = "--disable-multi-seat --with-fonts=freetype2 --disable-wlterm --with-video=dumb --with-renderers=bbulk"

SRC_URI[md5sum] = "0f6431b1f68a82701ceaf7db2e6a0736"
SRC_URI[sha256sum] = "f038c4d77b6cf2602fbcf3ea546e8ecced3cc3123134545f396030d82c52c8a5"

