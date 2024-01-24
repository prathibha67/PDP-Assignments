import { Component, OnInit, OnDestroy } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatSnackBar } from '@angular/material/snack-bar';
 
interface Transaction {
  date: Date;
  description: string;
  amount: number;
  balance: number;
}
 
@Component({
  selector: 'app-banking',
  templateUrl: './banking.component.html',
  styleUrls: ['./banking.component.css']
})
export class BankingComponent implements OnInit, OnDestroy {
  displayedColumns: string[] = ['date', 'description', 'amount','balance'];
  dataSource: MatTableDataSource<Transaction>;
 
  transactions: Transaction[] = [
    { date: new Date('2023-12-22'), description: 'Purchase', amount: -100, balance:60 },
    { date: new Date('2023-12-24'), description: 'Deposit', amount: 200, balance:0  },
    ...this.calculateBalances(),
  ];
 
  timePeriods = [15, 30, 1]; 
  selectedTimePeriod: number = this.timePeriods[0];
 
  constructor(private snackBar: MatSnackBar) {
    this.dataSource = new MatTableDataSource(this.transactions);
  }
 
  ngOnInit(): void {
    this.showSnackBar('Component initialized');
    
  }
 
  ngOnDestroy(): void {
    this.showSnackBar('Component destroyed');
  }
 
  
  applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
 
  updateStatement(): void {
    const filteredTransactions = this.getFilteredTransactions(this.selectedTimePeriod);
    this.dataSource.data = filteredTransactions;
  }
 
  getFilteredTransactions(timePeriod: number): Transaction[] {
    const currentDate = new Date();
    const startDate = new Date();
 
    if (timePeriod === 15) {
      startDate.setDate(currentDate.getDate() - 15);
    } else if (timePeriod === 30) {
      startDate.setDate(currentDate.getDate() - 30);
    } else {
      startDate.setMonth(currentDate.getMonth() - 1);
    }
 
    return this.transactions.filter(
      (transaction) => transaction.date >= startDate && transaction.date <= currentDate
    );
  }
 
  getTotalAmount(): number {
    return this.dataSource.filteredData.reduce((total, transaction) => total + transaction.amount+ transaction.balance, 0);
  }
 
  private showSnackBar(message: string): void {
    this.snackBar.open(message, 'Close', {
      duration: 3000, 
      horizontalPosition: 'center',
      verticalPosition: 'top',
    });
  }
  
    calculateBalances(): Transaction[] {  
       if (!this.transactions || this.transactions.length === 0) 
       {     return [];   }   let runningBalance = 0;   return this.transactions.map(transaction => {    
          runningBalance += transaction.amount;     
      return { ...transaction, balance: runningBalance };   });
}
}