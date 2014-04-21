package com.asd.framework;

public class CmdMgr {
	public void submit(ICommand command) {
		command.execute();
	}
}
