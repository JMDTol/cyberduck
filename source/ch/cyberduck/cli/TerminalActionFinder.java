package ch.cyberduck.cli;

/*
 * Copyright (c) 2002-2014 David Kocher. All rights reserved.
 * http://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to:
 * feedback@cyberduck.io
 */

import org.apache.commons.cli.CommandLine;

/**
 * @version $Id$
 */
public final class TerminalActionFinder {

    private TerminalActionFinder() {
        //
    }

    public static TerminalAction get(final CommandLine input) {
        for(TerminalAction action : TerminalAction.values()) {
            if(input.hasOption(action.name())) {
                return action;
            }
        }
        return null;
    }
}
