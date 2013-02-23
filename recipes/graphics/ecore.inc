DESCRIPTION = "Ecore is the Enlightenment application framework library"
LICENSE = "MIT BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=d6ff2c3c85de2faf5fd7dcd9ccfc8886"
DEPENDS = "virtual/libiconv tslib curl eet evas glib-2.0 gnutls"
DEPENDS_virtclass-native = "eet-native evas-native gettext-native"
# optional
# DEPENDS += "directfb virtual/libsdl openssl virtual/libiconv"

inherit efl gettext

BBCLASSEXTEND = "native"
INC_PR = "r2"

do_configure_prepend() {
    touch ${S}/po/Makefile.in.in || true
    sed -i -e 's: po::g' ${S}/Makefile.am
}

FILESPATHPKG =. "${BPN}-${PV}:${BPN}:"

PACKAGES =+ "\
    ${PN}-con \
    ${PN}-config \
    ${PN}-desktop \
    ${PN}-directfb \
    ${PN}-sdl \
    ${PN}-evas \
    ${PN}-fb \
    ${PN}-file \
    ${PN}-imf-evas \
    ${PN}-imf \
    ${PN}-ipc \
    ${PN}-job \
    ${PN}-txt \
    ${PN}-x \
    ${PN}-input \
    "
# Some upgrade path tweaking
AUTO_LIBNAME_PKGS = ""

FILES_${PN} = "${libdir}/libecore*.so.* \
  ${bindir} \
"
FILES_${PN}-con = "${libdir}/libecore_con*.so.*"
FILES_${PN}-config = "${libdir}/libecore_config*.so.*"
FILES_${PN}-desktop = "${libdir}/libecore_desktop*.so.*"
FILES_${PN}-directfb = "${libdir}/libecore_directfb*.so.*"
FILES_${PN}-sdl = "${libdir}/libecore_sdl*.so.*"
FILES_${PN}-evas = "${libdir}/libecore_evas*.so.*"
FILES_${PN}-fb = "${libdir}/libecore_fb*.so.*"
FILES_${PN}-file = "${libdir}/libecore_file*.so.*"
FILES_${PN}-imf = "${libdir}/libecore_imf*.so.* \
  ${libdir}/ecore/immodules/*.so \
"
FILES_${PN}-imf-evas = "${libdir}/libecore_imf_evas*.so.*"
FILES_${PN}-ipc = "${libdir}/libecore_ipc*.so.*"
FILES_${PN}-job = "${libdir}/libecore_job*.so.*"
FILES_${PN}-txt = "${libdir}/libecore_txt*.so.*"
FILES_${PN}-x = "${libdir}/libecore_x*.so.*"
FILES_${PN}-input = "${libdir}/libecore_input*.so.*"

ECORE_OECONF = "\
  --x-includes=${STAGING_INCDIR}/X11 \
  --x-libraries=${STAGING_LIBDIR} \
  --enable-ecore-evas \
  --enable-abstract-sockets \
  --enable-ecore-con \
  --enable-ecore-ipc \
  --enable-ecore-file \
  --enable-inotify \
  --enable-ecore-evas-software-buffer \
  --disable-ecore-fb \
  --disable-ecore-x \
  --disable-ecore-x-composite \
  --disable-ecore-x-damage \
  --disable-ecore-x-dpms \
  --disable-ecore-x-randr \
  --disable-ecore-x-render \
  --disable-ecore-x-screensaver \
  --disable-ecore-x-shape \
  --disable-ecore-x-gesture \
  --disable-ecore-x-sync \
  --disable-ecore-x-xfixes \
  --disable-ecore-x-xinerama \
  --disable-ecore-x-xprint \
  --disable-ecore-x-xtest \
  --disable-ecore-x-cursor \
  --disable-ecore-x-input \
  --disable-ecore-x-dri \
  --disable-ecore-x-xcb \
  --disable-ecore-directfb \
  --disable-ecore-sdl \
  --disable-openssl \
  --disable-poll \
  --disable-xim \
  --disable-tslib \
  --disable-ecore-wayland \
  --disable-ecore-wayland-shm \
  --disable-ecore-wayland-egl \
  --disable-ecore-evas-fb \
  --disable-ecore-evas-software-x11 \
  --disable-ecore-imf-xim \
"

EXTRA_OECONF = "${ECORE_OECONF} \
                 --enable-curl \
"

EXTRA_OECONF_virtclass-native = "\
                 ${ECORE_OECONF} \
                 --disable-curl \
                 --disable-ecore-x-composite \
                 --disable-ecore-x-damage \
                 --disable-ecore-x-dpms \
                 --disable-ecore-x-randr \
                 --disable-ecore-x-render \
                 --disable-ecore-x-screensaver \
                 --disable-ecore-x-shape \
                 --disable-ecore-x-sync \
                 --disable-ecore-x-xfixes \
                 --disable-ecore-x-xinerama \
                 --disable-ecore-x-xprint \
                 --disable-ecore-x-xtest \
                 --disable-ecore-x-cursor \
                 --disable-ecore-x-input \
                 --disable-ecore-x-dri \
"
