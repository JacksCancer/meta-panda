SUMMARY = "Ducati firmware"
SECTION = "multimedia"
LICENSE = "TI"
LIC_FILES_CHKSUM = "file://ti-firmware-ipu-dce.license.txt;md5=bd402733d2669054ce3d16d450b6121a"

PR = "r1"

PV = "1.6+121009+114852+git5c3f2bc"

SRC_URI = "file://ti-firmware-ipu-dce_${PV}.tar.gz"

S = "${WORKDIR}/ti-firmware-ipu-dce-1.6+121009+114852+git5c3f2bc"

do_install() {
	install -d ${D}${base_libdir}/firmware/
	install -m 0644 ti-firmware-ipu-dce.xem3 ${D}${base_libdir}/firmware/ti-firmware-ipu-dce-1.6+121009.xem3
    ln -sf /lib/ti-firmware-ipu-dce-1.6+121009.xem3 ${D}/lib/firmware/ducati-m3-core0.xem3
}

FILES_${PN} += "${base_libdir}/firmware/"
