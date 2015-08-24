/******************************************************************************
 *  Copyright 2015 by OLTPBenchmark Project   *
 *            *
 *  Licensed under the Apache License, Version 2.0 (the "License");           *
 *  you may not use this file except in compliance with the License.          *
 *  You may obtain a copy of the License at   *
 *            *
 *    http://www.apache.org/licenses/LICENSE-2.0              *
 *            *
 *  Unless required by applicable law or agreed to in writing, software       *
 *  distributed under the License is distributed on an "AS IS" BASIS,         *
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  *
 *  See the License for the specific language governing permissions and       *
 *  limitations under the License.            *
 ******************************************************************************/

package com.oltpbenchmark.benchmarks.hyadapt.procedures;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.oltpbenchmark.api.Procedure;
import com.oltpbenchmark.api.SQLStmt;
import com.oltpbenchmark.benchmarks.hyadapt.HYADAPTConstants;

public class ReadRecord2 extends Procedure{
    public final SQLStmt readStmt = new SQLStmt(
            "SELECT FIELD1, FIELD2, FIELD3, FIELD4, FIELD5, FIELD6, FIELD7, FIELD8, FIELD9, FIELD10, FIELD11, FIELD12, FIELD13, FIELD14, FIELD15, FIELD16, FIELD17, FIELD18, FIELD19, FIELD20, FIELD21, FIELD22, FIELD23, FIELD24, FIELD25, "
                    + "FIELD26, FIELD27, FIELD28, FIELD29, FIELD30, FIELD31, FIELD32, FIELD33, FIELD34, FIELD35, FIELD36, FIELD37, FIELD38, FIELD39, FIELD40, FIELD41, FIELD42, FIELD43, FIELD44, FIELD45, FIELD46, FIELD47, FIELD48, FIELD49, FIELD50 "
                    + "FROM HTABLE WHERE H_KEY=?"     );

    //FIXME: The value in ysqb is a byteiterator
    public void run(Connection conn, int keyname, Map<Integer,Integer> results) throws SQLException {
        PreparedStatement stmt = this.getPreparedStatement(conn, readStmt);
        stmt.setInt(1, keyname);          
        ResultSet r=stmt.executeQuery();
        while(r.next())
        {
            for(int i=1; i<= ((HYADAPTConstants.FIELD_COUNT/10) * 2); i++)
                results.put(i, r.getInt(i));
        }        
        r.close();
    }

}
