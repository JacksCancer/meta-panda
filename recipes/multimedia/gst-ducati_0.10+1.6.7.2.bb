require gst-plugins.inc

LICENSE = "GPLv2+ & LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

DEPENDS += "gstreamer gst-plugins-base gst-plugins-bad libdrm libdce"

PR = "r1"

SRCREV= "47cd28afc4ed9d11d399dc6e6041101174b68212"
SRC_URI = "git://gitorious.org/gstreamer-omap/${BPN}.git;protocol=git"

inherit gettext

EXTRA_OECONF += ""

ARM_INSTRUCTION_SET = "arm"

CFLAGS += " -Wno-error=deprecated-declarations "

do_configure_prepend() {
	# This m4 file contains nastiness which conflicts with libtool 2.2.2
	rm ${S}/m4/lib-link.m4 || true
}

SRC_URI[md5sum] = "fcb09798114461955260e4d940db5987"
SRC_URI[sha256sum] = "0eae7d1a1357ae8377fded6a1b42e663887beabe0e6cc336e2ef9ada42e11491"
