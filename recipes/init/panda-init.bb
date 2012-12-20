LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PR = "r7"

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS = "busybox"

SRC_URI = " \
    file://rcS \
    file://passwd \
    file://group \
    file://remount-rootfs \
    file://resolv.conf \
    file://asound.state \
    "

do_install() {
    #install -d ${D}${base_sbindir}
	#install -m 0755 init.sh ${D}${base_sbindir}
    #ln -sf /bin/busybox ${D}${base_sbindir}/init
    
    install -d ${D}${sbindir}
    install -m 0744 ${WORKDIR}/remount-rootfs ${D}${sbindir}
    ln -sf ${sbindir}/remount-rootfs ${D}${sbindir}/rw
    ln -sf ${sbindir}/remount-rootfs ${D}${sbindir}/ro
    
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/rcS ${D}${sysconfdir}/init.d/
    install -m 0644 ${WORKDIR}/passwd ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/group ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/resolv.conf ${D}${sysconfdir}
    
    install -m 0644 ${WORKDIR}/asound.state ${D}${sysconfdir}
}
