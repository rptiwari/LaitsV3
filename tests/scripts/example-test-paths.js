/**
 *Dragoon Project
 *Arizona State University
 *(c) 2014, Arizona Board of Regents for and on behalf of Arizona State University
 *
 *This file is a part of Dragoon
 *Dragoon is free software: you can redistribute it and/or modify
 *it under the terms of the GNU Lesser General Public License as published by
 *the Free Software Foundation, either version 3 of the License, or
 *(at your option) any later version.
 *
 *Dragoon is distributed in the hope that it will be useful,
 *but WITHOUT ANY WARRANTY; without even the implied warranty of
 *MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.	See the
 *GNU Lesser General Public License for more details.
 *
 *You should have received a copy of the GNU Lesser General Public License
 *along with Dragoon.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

/*
  INSTRUCTIONS:
  
  Do **NOT** modify example-test-paths.js.

  Instead, Copy this file to "test-paths.js", then change the settings to match
  your setup.
*/

exports.getLocalPath = function()
{
	return "http://localhost/dragoon/www/index.html"
}

exports.getTestTarget = function()
{
	//Change this to "demo", "devel", "pal3", or "local" depending on what you wish to test
	return "local";
}