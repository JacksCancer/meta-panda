inherit autotools pkgconfig

SUMMARY = "Weston, a Wayland compositor"
DESCRIPTION = "Weston is the reference implementation of a Wayland compositor"
HOMEPAGE = "http://wayland.freedesktop.org"
SECTION = "wayland/base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=275efac2559a224527bd4fd593d38466"

DEPENDS = "wayland libxkbcommon gdk-pixbuf pixman cairo glib-2.0 mtdev jpeg"
DEPENDS += "virtual/egl libpam"

EXTRA_OECONF  = "--enable-wayland-compositor --disable-android-compositor"
EXTRA_OECONF += "--enable-setuid-install --enable-simple-clients"
EXTRA_OECONF += "--enable-clients --disable-xwayland"

PACKAGECONFIG ??= "${@base_contains('DISTRO_FEATURES', 'wayland', 'kms', '', d)} \
                   ${@base_contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
                   ${@base_contains('DISTRO_FEATURES', 'opengles2', 'gles', '', d)} \
                  "
PACKAGECONFIG[kms] = "--enable-drm-compositor,--disable-drm-compositor,drm libdrm libgbm udev wayland-egl libpam"
PACKAGECONFIG[x11] = "--enable-x11-compositor,--disable-x11-compositor,virtual/libx11 libxcb libxcb libxcursor cairo"
PACKAGECONFIG[gles] = "--with-cairo-glesv2,,virtual/libgles2"
