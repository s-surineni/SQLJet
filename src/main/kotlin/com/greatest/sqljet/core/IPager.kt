package com.greatest.sqljet.core

/**
 * This header file defines the interface that the sqlite page cache
 * subsystem uses.  The page cache subsystem reads and writes a file a page
 * at a time and provides a journal for rollback.
 */
abstract class IPager {
    var SQLITE_DEFAULT_JOURNAL_SIZE_LIMIT = -1

    /*
    ** Allowed values for the flags parameter to sqlite3PagerOpen().
    **
    ** NOTE: This values must match the corresponding BTREE_ values in btree.h.
    */
    var PAGER_OMIT_JOURNAL = 0x0001 /* Do not use a rollback journal */
    var PAGER_NO_READLOCK = 0x0002 /* Omit readlocks on readonly files */

    /*
    ** Valid values for the second argument to sqlite3PagerLockingMode().
    */
    var PAGER_LOCKINGMODE_QUERY = -1
    var PAGER_LOCKINGMODE_NORMAL = 0
    var PAGER_LOCKINGMODE_EXCLUSIVE = 1

    /*
    ** Valid values for the second argument to sqlite3PagerJournalMode().
    */
    var PAGER_JOURNALMODE_QUERY = -1
    var PAGER_JOURNALMODE_DELETE = 0 /* Commit by deleting journal file */
    var PAGER_JOURNALMODE_PERSIST = 1 /* Commit by zeroing journal header */
    var PAGER_JOURNALMODE_OFF = 2 /* Journal omitted.  */

    /*
   * int sqlite3PagerOpen(sqlite3_vfs *, Pager **ppPager, const char*, void(*)(DbPage*), int,int,int);
   */

    /*
   * int sqlite3PagerOpen(sqlite3_vfs *, Pager **ppPager, const char*, void(*)(DbPage*), int,int,int);
   */
    abstract fun open(
        fileName: String?,  /* Name of the database file to open */
        xDesc: IPageDestructor?,  /* Page destructor function */
        nExtra: Int,  /* Extra bytes append to each in-memory page */
        flags: Int /* flags controlling this file */
    )
}