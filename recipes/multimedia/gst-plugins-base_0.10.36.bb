require gst-plugins.inc

LICENSE = "GPLv2+ & LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3 \
                    file://COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605 \
                    file://gst/ffmpegcolorspace/utils.c;beginline=1;endline=20;md5=9c83a200b8e597b26ca29df20fc6ecd0"

DEPENDS += "alsa-lib freetype liboil libogg libvorbis libtheora util-linux tremor"

SRC_URI += "file://gst-plugins-base-tremor.patch \
            file://configure.ac-fix-subparse-plugin.patch"

SRCREV = "c779786a365a040d775fb26082fa573099f42dd1"

SRC_URI[md5sum] = "776c73883e567f67b9c4a2847d8d041a"
SRC_URI[sha256sum] = "2cd3b0fa8e9b595db8f514ef7c2bdbcd639a0d63d154c00f8c9b609321f49976"

PR = "r1"

inherit gettext

EXTRA_OECONF += "--disable-freetypetest --disable-pango --disable-gnome_vfs --disable-orc"

do_configure_prepend() {
	# This m4 file contains nastiness which conflicts with libtool 2.2.2
	rm -f ${S}/m4/lib-link.m4
}

FILES_${PN} += "${datadir}/${BPN}"
