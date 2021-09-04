package com.greatest.sqljet.core

interface IPageDestructor {
    /*
    ** This routine is called when the reference count for a page
    ** reaches zero.  We need to unref the pParent pointer when that
    ** happens.
    */
    fun pageDestructor(page: IPage?)
}