COMPATIBLE_MACHINE = "omap4"

require linux.inc

# The main PR is now using MACHINE_KERNEL_PR, for omap4 see conf/machine/include/omap4.inc
MACHINE_KERNEL_PR_append = "a"

CORTEXA8FIXUP = "no"

SRCREV = "1bad36ba621ecccd458f14f78e8c06318ff50eba"

SRC_URI = "git://git.linaro.org/landing-teams/working/ti/kernel.git;protocol=git;branch=tilt-3.4 \
           file://defconfig \
           "

SRC_URI[defconfig.md5sum] = "f6541f8bc2401c5a7ea0b9aa6119d6be"
SRC_URI[defconfig.sha256sum] = "b4f4f1060b0664481f87dd7a4dbd64c128ab6da46832465780d675882468990e"

S = "${WORKDIR}/git"
