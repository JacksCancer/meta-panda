DESCRIPTION = "Evas is the Enlightenment canvas API"
LICENSE = "MIT BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=b9b25b03d63aa496552658c7e78b11a1"
# can also depend on valgrind, libsdl-x11, directfb
DEPENDS = "eina eet freetype jpeg libpng tiff fontconfig libfribidi giflib"
DEPENDS_virtclass-native = "freetype-native libpng-native jpeg-native tiff-native eet-native eina-native libfribidi-native"

inherit efl

BBCLASSEXTEND = "native"
INC_PR = "r2"
FILESPATHPKG =. "${BPN}-${PV}:${BPN}:"

python populate_packages_prepend () {
    for plugin_type in "engines loaders savers".split():
        bb.note( "splitting packages for evas %s..." % plugin_type )
        basedir = d.expand( '${libdir}/evas/modules/%s' % plugin_type)

        do_split_packages(d, basedir, '^(.*)',
        output_pattern = 'evas-' + plugin_type[:-1] + "-%s",
        description = 'Evas module %s',
        allow_dirs=True, recursive=False, extra_depends="" )
        
        plugin_type = "cserve2"
        bb.note( "splitting packages for evas %s..." % plugin_type )
        basedir = d.expand( '${libdir}/evas/%s/loaders' % plugin_type)

        do_split_packages(d, basedir, '^(.*)',
        output_pattern = 'evas-' + plugin_type + "-%s",
        description = 'Evas csever2 loader module %s',
        allow_dirs=True, recursive=False, extra_depends="" )
}

do_install_append() {
    find "${D}" -name .debug -type d -exec rm -rf {} \;
}

FILES_${PN}-dev += "${libdir}/evas/modules/*/*/*/*.a ${libdir}/evas/modules/*/*/*/*.la"
FILES_${PN}-dbg += "${libdir}/evas/modules/*/*/*/.debug/ ${libdir}/evas/cserve2/loaders/*/*/.debug/"
FILES_${PN}-cserve2 += "${libexecdir}/evas_cserve2* ${libexecdir}/dummy_slave"

PACKAGES += "${PN}-cserve2"
PACKAGES_DYNAMIC += "^evas-engine-.* ^evas-loader-.* ^evas-saver-.* ^evas-cserve2-.*"

# evas-loader-svg is gone as we don't have esvg and probably won't have anytime soon
# http://www.intesis.hr/news/16-esvg-source
# http://blog.gmane.org/gmane.comp.window-managers.enlightenment.user/page=3
RRECOMMENDS_${PN} += "evas-loader-generic evas-generic-loader-svn"

RRECOMMENDS_${PN} = " \
  evas-engine-software-generic \
  evas-engine-software-16 \
 \
  evas-loader-png \
  evas-loader-jpeg \
  evas-loader-gif \
"

# Some upgrade path tweaking
AUTO_LIBNAME_PKGS = ""

EVAS_CPU_TWEAKS = ""
# Disabled for now, see http://thread.gmane.org/gmane.comp.window-managers.enlightenment.devel/25194
EVAS_CPU_TWEAKS_armv7a = "--disable-cpu-neon"

# common options
EVAS_OECONF = " \
                --x-includes=${STAGING_INCDIR}/X11 \
                --x-libraries=${STAGING_LIBDIR} \
                --enable-evas-magic-debug \
                --disable-directfb \
                --enable-buffer=static \
                --enable-static-software-generic \
                --disable-software-ddraw \
                --disable-software-xcb \
                --disable-software-x11 \
                --disable-software-16-x11 \
                --disable-gl-x11 \
                --disable-gl-xlib \
                --disable-xrender-x11 \
                --enable-image-loader-eet=static \
                --disable-image-loader-edb \
                --enable-image-loader-png \
                --enable-image-loader-jpeg \
                --enable-image-loader-tiff \
                --enable-cpu-c \
                --enable-fontconfig \
                --enable-font-loader-eet \
                --enable-scale-sample \
                --enable-scale-smooth \
                --enable-convert-yuv \
                --enable-small-dither-mask \
                --disable-no-dither-mask \
                --disable-convert-8-rgb-332 \
                --disable-convert-8-rgb-666 \
                --disable-convert-8-rgb-232 \
                --disable-convert-8-rgb-222 \
                --disable-convert-8-rgb-221 \
                --disable-convert-8-rgb-121 \
                --disable-convert-8-rgb-111 \
                --enable-convert-16-rgb-565 \
                --disable-convert-16-rgb-555 \
                --disable-convert-16-rgb-444 \
                --disable-convert-16-rgb-ipq \
                --enable-convert-16-rgb-rot-0 \
                --enable-convert-16-rgb-rot-90 \
                --disable-convert-16-rgb-rot-180 \
                --enable-convert-16-rgb-rot-270 \
"

# either sgx or 6410 atm
GLES ?= "sgx"

# This is a hack to get openGL|ES 2.x support enabled for people that have the SDK headers in staging.
# We put this in the main recipe, since it will just not build the gl stuff when the headers are missing

# If the above sentence confuse you: everything is built and configured as before if you don't have the SDK

EXTRA_OECONF = "${EVAS_OECONF} \
                ${EVAS_CPU_TWEAKS} \
                --enable-pthreads \
                --enable-async-events \
                --enable-async-preload \
                --enable-image-loader-gif \
                --enable-convert-24-rgb-888 \
                --enable-convert-24-bgr-888 \
                --enable-convert-32-rgb-8888 \
                --enable-convert-32-rgbx-8888 \
                --enable-convert-32-bgr-8888 \
                --enable-convert-32-bgrx-8888 \
                --enable-convert-32-rgb-rot-0 \
                --enable-convert-32-rgb-rot-90 \
                --disable-convert-32-rgb-rot-180 \
                --enable-convert-32-rgb-rot-270 \
"
EXTRA_OECONF_virtclass-native = "${EVAS_OECONF} \
                --disable-software-x11 \
                --disable-software-16-x11 \
                --disable-gl-x11 \
                --disable-gl-xlib \
                --disable-xrender-x11 \
                --disable-image-loader-gif \
                --disable-image-loader-svg \
                --disable-convert-24-rgb-888 \
                --disable-convert-24-bgr-888 \
                --disable-convert-32-rgb-8888 \
                --disable-convert-32-rgbx-8888 \
                --disable-convert-32-bgr-8888 \
                --disable-convert-32-bgrx-8888 \
                --disable-convert-32-rgb-rot-0 \
                --disable-convert-32-rgb-rot-90 \
                --disable-convert-32-rgb-rot-270 \
"
