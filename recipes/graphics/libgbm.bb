inherit autotools pkgconfig

SUMMARY = "libgbm"
SECTION = "wayland/base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://gbm.h;beginline=1;endline=26;md5=b871c7f2f477df29ee4c0ec437b187f7"

DEPENDS = "libdrm udev"

PR = "r1"

SRCREV = "501ff0a00649b339f063f7b88c2477fd6ea9bff4"
SRC_URI = " \
	git://gitorious.org/ubuntu-omap/libgbm.git;protocol=git \
	file://Makefile.am-add-version-info.patch"

S = "${WORKDIR}/git"


