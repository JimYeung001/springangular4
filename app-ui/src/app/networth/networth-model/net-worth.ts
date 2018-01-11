import { CashInvestment } from './cash-investment';
import { LongTermAsset } from './long-term-asset';
import { ShortTermLiab } from './short-term-liab';
import { LongTermDebt } from './long-term-debt';

export class NetWorth {
    id: number;
    totalAssets: number;
    totalLiabilities: number;
    netWorth: number;
    cashAndInvestments: CashInvestment;
    longTermAssets: LongTermAsset;
    shortTermLiab: ShortTermLiab;
    longTermDebt: LongTermDebt;

    constructor() { }
}