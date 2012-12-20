SUMMARY = "Ducati firmware"
SECTION = "multimedia"
LICENSE = "TI"
LIC_FILES_CHKSUM = "file://ti-firmware-ipu-dce.license.txt;md5=bd402733d2669054ce3d16d450b6121a"

PR = "r1"

PV = "1.6+121207+151913+git17438c0"

SRC_URI = "file://ti-firmware-ipu-dce_${PV}.tar.gz"

S = "${WORKDIR}/ducati-dce-ee4f5fd145de23fb00ee61a4f98dc4f8ae7d812e"

do_install() {
	install -d ${D}${base_libdir}/firmware/
	install -m 0644 ti-firmware-ipu-dce.* ${D}${base_libdir}/firmware/
    ln -sf /lib/firmware/ti-firmware-ipu-dce.xem3 ${D}/lib/firmware/ducati-m3-core0.xem3
}

FILES_${PN} += "${base_libdir}/firmware/"
