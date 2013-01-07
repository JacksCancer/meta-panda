require gst-plugins.inc

LICENSE = "GPLv2+ & LGPLv2+ & LGPLv2.1+ "
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3\
                    file://gst/tta/filters.h;beginline=12;endline=29;md5=629b0c7a665d155a6677778f4460ec06 \
                    file://COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605 \
                    file://gst/tta/crc32.h;beginline=12;endline=29;md5=71a904d99ce7ae0c1cf129891b98145c"

DEPENDS += "gst-plugins-base gst-plugins-good gst-plugins-ugly gst-ffmpeg libdrm bzip2 libdce faad2"

PR = "r6"

SRCREV= "9dce1a7317676c41136c83654677530ec3f30b1b"

SRC_URI += " \
		file://wayland-add-gst-plugins-bad-cflags.patch \
		"

inherit gettext

EXTRA_OECONF += "--disable-examples --enable-experimental --disable-sdl --disable-cdaudio --disable-directfb \
                 --with-plugins=videoparsers,h264parse,musicbrainz,wavpack,ivorbis,mpegvideoparse,mpegdemux,mpegpsmux,mpegtsdemux,mpegtsmux,kms \
                 --disable-vdpau --disable-apexsink \
                 --disable-orc --disable-pvr"

ARM_INSTRUCTION_SET = "arm"

do_configure_prepend() {
	# This m4 file contains nastiness which conflicts with libtool 2.2.2
	rm ${S}/m4/lib-link.m4 || true
}

SRC_URI[md5sum] = "fcb09798114461955260e4d940db5987"
SRC_URI[sha256sum] = "0eae7d1a1357ae8377fded6a1b42e663887beabe0e6cc336e2ef9ada42e11491"
