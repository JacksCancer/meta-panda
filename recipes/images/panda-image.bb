LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

#IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp"

IMAGE_FEATURES += "package-management"

IMAGE_INSTALL += " \
    base-files \
    busybox \
    strace \
    ti-firmware-ipu-dce \
    libdce \
    gstreamer \
    gst-plugins-base-meta \
    gst-plugins-good-meta \
    gst-plugins-bad-meta \
    gst-plugins-ugly-meta \
    gst-ducati-meta \
    gst-ffmpeg \
    alsa-utils \
    alsa-ucm-conf \
    iw \
    wpa-supplicant \
    wl12xx-firmware \
    libnl \
    libnl-genl \
    libssl \
    gnutls \
    libcrypto \
    packagegroup-core-ssh-dropbear \
    opkg \
    panda-feed-config-opkg \
    panda-init \
    pvr-omap4 \
    tiomapconf \
    weston \
    wayland \
    xkeyboard-config \
    kmscon \
    elementary \
    eeze \
    xorg-minimal-fonts \
    ttf-bitstream-vera \
    liberation-fonts \
    gdbserver \
    gdb \
"

#panda-init \
#	packagegroup-core-boot \
#	tinylogin shadow \
#    udev \
#	systemd \
#    ${CONMANPKGS} \

export IMAGE_BASENAME = "panda-image"

inherit core-image

