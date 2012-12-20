PRINC := "${@int(PRINC) + 1}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "file://remove-softfp-flags.patch;name=patch"

SRC_URI[patch.md5sum] = "8a446a3897bd690362cb3931c8cbfbb9"
SRC_URI[patch.sha256sum] = "677a048e8ca55c824bf8b3cd409046b66abd26847c9d0fdff47417d1f400ded5"
