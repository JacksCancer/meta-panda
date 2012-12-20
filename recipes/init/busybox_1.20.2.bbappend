PRINC := "${@int(PRINC) + 3}"

SRC_URI += "file://mdev.conf"

def enable_features(features):
    return "".join([' -e "s/# ' + f + ' is not set/' + f + '=y/"' for f in features])

BUSYBOX_INIT_FEATURES_SCRIPT := "${@enable_features([\
    'CONFIG_MDEV', \
    'CONFIG_FEATURE_MDEV_LOAD_FIRMWARE', \
    'CONFIG_INIT', \
    'CONFIG_FEATURE_USE_INITTAB', \
    'CONFIG_FEATURE_INIT_SCTTY', \
    'CONFIG_FEATURE_INIT_SYSLOG', \
    'CONFIG_FEATURE_EXTRA_QUIET', \
    'CONFIG_FEATURE_INIT_COREDUMPS', \
    'CONFIG_USE_BB_PWD_GRP', \
    'CONFIG_RUNLEVEL', \
    'CONFIG_LOGIN'])}"

do_configure_prepend() {
	#sed -i \
#        -e 's/# CONFIG_INIT is not set/CONFIG_INIT=y/'\
#        -e "s/# CONFIG_FEATURE_USE_INITTAB is not set/CONFIG_FEATURE_USE_INITTAB=y/"\

    sed -i ${BUSYBOX_INIT_FEATURES_SCRIPT} \
        -e 's/CONFIG_INIT_TERMINAL_TYPE=""/CONFIG_INIT_TERMINAL_TYPE="linux"/' \
        ${WORKDIR}/defconfig
}

do_install_append() {
    install -m 0644 ${WORKDIR}/mdev.conf ${D}${sysconfdir}
    
    # remove write of resolv.conf, it's a read-only fs
    sed -i -e 's/echo .*>.*RESOLV_CONF.*$/echo \$R/' \
        ${D}${sysconfdir}/udhcpc.d/50default
}
