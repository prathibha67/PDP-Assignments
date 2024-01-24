import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';

interface Transaction {
  date: string;
  description: string;
  amount: number;
}

@Component({
  selector: 'app-banking',
  templateUrl: './banking.component.html',
  styleUrls: ['./banking.component.css']
})
export class BankingComponent implements OnInit {
  displayedColumns: string[] = ['date', 'description', 'amount'];
  dataSource: MatTableDataSource<Transaction>;

  transactions: Transaction[] = [
    { date: '2023-11-06', description: 'Purchase', amount: 50 },
    { date: '2023-11-27', description: 'Deposit', amount: 200 },
    { date: '2023-11-24', description: 'Cosmetic', amount: 100 },
    { date: '2023-11-12', description: 'Credit', amount: 3000 },
    { date: '2023-11-13', description: 'Deposit', amount: 200 },
    { date: '2023-10-14', description: 'Deposit', amount: 200 },
    // Add more transactions as needed
  ];

  timePeriods = [15, 30,1]; // 15 days, 30 days, last month
  selectedTimePeriod: number = this.timePeriods[0];

  constructor() {
    this.dataSource = new MatTableDataSource(this.transactions);
  }

  ngOnInit(): void {
    this.updateStatement();
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
      (transaction) => new Date(transaction.date) >= startDate && new Date(transaction.date) <= currentDate
    );
  }

  getTotalAmount(): number {
    return this.dataSource.filteredData.reduce((total, transaction) => total + transaction.amount, 0);
  }
}
