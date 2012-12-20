TOOLCHAIN_TARGET_TASK = "packagegroup-panda-standalone-sdk-target packagegroup-panda-standalone-sdk-target-dbg"
TOOLCHAIN_OUTPUTNAME = "${SDK_NAME}-toolchain-panda-${DISTRO_VERSION}"
require recipes-core/meta/meta-toolchain.bb

TOOLCHAIN_NEED_CONFIGSITE_CACHE += "zlib"
