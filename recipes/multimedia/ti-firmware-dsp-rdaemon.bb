SUMMARY = "Tesla firmware"
SECTION = "multimedia"
LICENSE = "TI"
LIC_FILES_CHKSUM = "file://ti-firmware-dsp-rdaemon.license.txt;md5=bd402733d2669054ce3d16d450b6121a"

PR = "r0"

PV = "1.6+121207+154857+git17438c0"

SRC_URI = "file://ti-firmware-dsp-rdaemon_${PV}.tar.gz"

S = "${WORKDIR}/tesla-rdaemon-bfaac0fa5aa95f148d001adbab5fb5397fb9fbe7"

do_install() {
	install -d ${D}${base_libdir}/firmware/
	install -m 0644 ti-firmware-dsp-rdaemon.* ${D}${base_libdir}/firmware/
    ln -sf /lib/firmware/ti-firmware-dsp-rdaemon.xe64T ${D}/lib/firmware/tesla-dsp.xe64T
}

#PACKAGE_ARCH = "${MACHINE_ARCH}"

INSANE_SKIP_${PN} = "True"

FILES_${PN} += "${base_libdir}/firmware/"
