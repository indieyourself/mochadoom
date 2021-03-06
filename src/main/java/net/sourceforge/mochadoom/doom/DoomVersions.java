package net.sourceforge.mochadoom.doom;

import net.sourceforge.mochadoom.defines.GameMode;

import java.util.Hashtable;

import net.sourceforge.mochadoom.utils.C2JUtils;

public class DoomVersions {

    public final static Hashtable<String, GameMode> VersionChecker = new Hashtable<String, GameMode>();

    static {
        VersionChecker.put("doom.wad", GameMode.registered);
        VersionChecker.put("doom2.wad", GameMode.commercial);
        VersionChecker.put("udoom.wad", GameMode.retail);
        VersionChecker.put("tnt.wad", GameMode.pack_tnt);
        VersionChecker.put("plutonia.wad", GameMode.pack_plut);
        VersionChecker.put("doom1.wad", GameMode.shareware);
        VersionChecker.put("xbla.wad", GameMode.pack_xbla);
        VersionChecker.put("freedoom1.wad", GameMode.freedoom1);
        VersionChecker.put("freedoom2.wad", GameMode.freedoom2);
    }

    public DoomVersions() {

    }

    /**
     * Try all versions in given doommwaddir
     */

    public void tryThemAll(String doomwaddir) {
        // Commercial.
        doom2wad = (doomwaddir + "/doom2.wad");

        // Retail.
        doomuwad = (doomwaddir + "/doomu.wad");

        // Registered.
        doomwad = (doomwaddir + "/doom.wad");

        // Shareware.
        doom1wad = (doomwaddir + "/doom1.wad");

        freedoom1wad = (doomwaddir + "/freedoom1.wad");

        freedoom2wad = (doomwaddir + "/freedoom2.wad");

        // Bug, dear Shawn.
        // Insufficient malloc, caused spurious realloc errors.
        plutoniawad = (doomwaddir + "/plutonia.wad");

        tntwad = (doomwaddir + "/tnt.wad");

        xblawad = (doomwaddir + "/xbla.wad");

        // French stuff.
        doom2fwad = (doomwaddir + "/doom2f.wad");
    }

    public String
            doom1wad,
            doomwad,
            doomuwad,
            doom2wad,
            doom2fwad,
            plutoniawad,
            tntwad,
            xblawad,
            freedoom1wad,
            freedoom2wad;

    /**
     * Try only one IWAD.
     *
     * @param iwad
     * @return
     */

    public GameMode tryOnlyOne(String iwad, String doomwaddir) {

        // Is it a known and valid version?
        GameMode tmp = VersionChecker.get(iwad.toLowerCase());
        if (tmp != null) {
            // Can we read it?
            if (C2JUtils.testReadAccess(doomwaddir + iwad))
                return tmp; // Yes, so communicate the gamemode back.
        }

        // It's either invalid or we can't read it.
        // Fuck that.
        return null;
    }


}
