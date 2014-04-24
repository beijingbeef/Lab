package com.asd.framework;

import java.util.ArrayList;
import java.util.Iterator;

public class Entries extends ArrayList<IEntry> {

	public void doAll(IPredicate p, IFunctor f) {
		Iterator<IEntry> it = this.iterator();
		while (it.hasNext()) {
			IEntry v = it.next();
			if (p.check(v)) {
				f.compute(v);
			}
		}
	}

}
