/******************************************************************************
 *  Copyright 2015 by OLTPBenchmark Project                                   *
 *                                                                            *
 *  Licensed under the Apache License, Version 2.0 (the "License");           *
 *  you may not use this file except in compliance with the License.          *
 *  You may obtain a copy of the License at                                   *
 *                                                                            *
 *    http://www.apache.org/licenses/LICENSE-2.0                              *
 *                                                                            *
 *  Unless required by applicable law or agreed to in writing, software       *
 *  distributed under the License is distributed on an "AS IS" BASIS,         *
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  *
 *  See the License for the specific language governing permissions and       *
 *  limitations under the License.                                            *
 ******************************************************************************/

package com.oltpbenchmark.benchmarks.hyadapt;

import java.sql.SQLException;
import java.util.HashMap;

import com.oltpbenchmark.api.BenchmarkModule;
import com.oltpbenchmark.api.Procedure;
import com.oltpbenchmark.api.Procedure.UserAbortException;
import com.oltpbenchmark.api.TransactionType;
import com.oltpbenchmark.api.Worker;
import com.oltpbenchmark.benchmarks.hyadapt.procedures.ReadRecord1;
import com.oltpbenchmark.benchmarks.hyadapt.procedures.ReadRecord2;
import com.oltpbenchmark.benchmarks.hyadapt.procedures.ReadRecord3;
import com.oltpbenchmark.benchmarks.hyadapt.procedures.ReadRecord4;
import com.oltpbenchmark.benchmarks.hyadapt.procedures.ReadRecord5;
import com.oltpbenchmark.benchmarks.hyadapt.procedures.ReadRecord6;
import com.oltpbenchmark.benchmarks.hyadapt.procedures.ReadRecord7;
import com.oltpbenchmark.benchmarks.hyadapt.procedures.ReadRecord8;
import com.oltpbenchmark.benchmarks.hyadapt.procedures.ReadRecord9;
import com.oltpbenchmark.benchmarks.hyadapt.procedures.ReadRecord10;
import com.oltpbenchmark.distributions.CounterGenerator;
import com.oltpbenchmark.types.TransactionStatus;

public class HYADAPTWorker extends Worker {

    private static CounterGenerator insertRecord;
    private double selectivity = wrkld.getSelectivity();
    private int key_lower_bound = (int) ((1 - selectivity) * HYADAPTConstants.RANGE);
            
    public HYADAPTWorker(int id, BenchmarkModule benchmarkModule, int init_record_count) {
        super(benchmarkModule, id);
        
        synchronized (HYADAPTWorker.class) {
            // We must know where to start inserting
            if (insertRecord == null) {
                insertRecord = new CounterGenerator(init_record_count);
            }
        } // SYNCH
    }

    @Override
    protected TransactionStatus executeWork(TransactionType nextTrans) throws UserAbortException, SQLException {
        Class<? extends Procedure> procClass = nextTrans.getProcedureClass();
                
        if (procClass.equals(ReadRecord1.class)) {
            readRecord1();
        } else if (procClass.equals(ReadRecord2.class)) {
            readRecord2();
        } else if (procClass.equals(ReadRecord3.class)) {
            readRecord3();
        } else if (procClass.equals(ReadRecord4.class)) {
            readRecord4();
        } else if (procClass.equals(ReadRecord5.class)) {
            readRecord5();
        } else if (procClass.equals(ReadRecord6.class)) {
            readRecord6();
        } else if (procClass.equals(ReadRecord7.class)) {
            readRecord7();
        } else if (procClass.equals(ReadRecord8.class)) {
            readRecord8();
        } else if (procClass.equals(ReadRecord9.class)) {
            readRecord9();
        } else if (procClass.equals(ReadRecord10.class)) {
            readRecord10();
        }
        
        conn.commit();
        return (TransactionStatus.SUCCESS);
    }

    private void readRecord1() throws SQLException {
        ReadRecord1 proc = this.getProcedure(ReadRecord1.class);
        assert (proc != null);
        proc.run(conn, key_lower_bound, new HashMap<Integer, Integer>());
    }

    private void readRecord2() throws SQLException {
        ReadRecord2 proc = this.getProcedure(ReadRecord2.class);
        assert (proc != null);
        proc.run(conn, key_lower_bound, new HashMap<Integer, Integer>());
    }

    private void readRecord3() throws SQLException {
        ReadRecord3 proc = this.getProcedure(ReadRecord3.class);
        assert (proc != null);
        proc.run(conn, key_lower_bound, new HashMap<Integer, Integer>());
    }

    private void readRecord4() throws SQLException {
        ReadRecord4 proc = this.getProcedure(ReadRecord4.class);
        assert (proc != null);
        proc.run(conn, key_lower_bound, new HashMap<Integer, Integer>());
    }

    private void readRecord5() throws SQLException {
        ReadRecord5 proc = this.getProcedure(ReadRecord5.class);
        assert (proc != null);
        proc.run(conn, key_lower_bound, new HashMap<Integer, Integer>());
    }

    private void readRecord6() throws SQLException {
        ReadRecord6 proc = this.getProcedure(ReadRecord6.class);
        assert (proc != null);
        proc.run(conn, key_lower_bound, new HashMap<Integer, Integer>());
    }

    private void readRecord7() throws SQLException {
        ReadRecord7 proc = this.getProcedure(ReadRecord7.class);
        assert (proc != null);
        proc.run(conn, key_lower_bound, new HashMap<Integer, Integer>());
    }

    private void readRecord8() throws SQLException {
        ReadRecord8 proc = this.getProcedure(ReadRecord8.class);
        assert (proc != null);
        proc.run(conn, key_lower_bound, new HashMap<Integer, Integer>());
    }

    private void readRecord9() throws SQLException {
        ReadRecord9 proc = this.getProcedure(ReadRecord9.class);
        assert (proc != null);
        proc.run(conn, key_lower_bound, new HashMap<Integer, Integer>());
    }

    private void readRecord10() throws SQLException {
        ReadRecord10 proc = this.getProcedure(ReadRecord10.class);
        assert (proc != null);
        proc.run(conn, key_lower_bound, new HashMap<Integer, Integer>());
    }

}
