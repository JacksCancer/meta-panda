DESCRIPTION = "Plugins for GStreamer"
HOMEPAGE = "http://gstreamer.freedesktop.org/"
BUGTRACKER = "https://bugzilla.gnome.org/enter_bug.cgi?product=Gstreamer"
SECTION = "multimedia"
DEPENDS = "gstreamer"

inherit autotools pkgconfig

FILESPATH =. "${FILE_DIRNAME}/gst-plugins:"

SRC_URI = "git://gitorious.org/gstreamer-omap/${BPN}.git;branch=${PV};protocol=git"
S = "${WORKDIR}/git"

GSTREAMER_DEBUG ?= "--disable-debug"
EXTRA_OECONF = "--disable-valgrind ${GSTREAMER_DEBUG} --disable-examples "

require gst-plugins-package-1.0.inc

do_configure_prepend () {
    ./autogen.sh --noconfigure
}

PACKAGES_DYNAMIC += "^${PN}-.*"

