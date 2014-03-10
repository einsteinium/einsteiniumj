package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: HashEngineering
 * Date: 8/13/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


        public static final String coinName = "Einsteinium";
        public static final String coinTicker = "EMC2";
        public static final String coinURIScheme = "einsteinium";
        public static final String cryptsyMarketId = "151";
        public static final String cryptsyMarketCurrency = "BTC";
        public static final String alternateExchangeInfo = "http://bter.com/trade/vtc_btc";


        public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://cryptexplorer.com/";
        public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://cryptexplorer.com/";

        public static final String DONATION_ADDRESS = "ES9oQDrK44U5fHv58SqjLkRLBoNaErpDV2";  //G4E Studios donation EMC2 address

        enum CoinHash {
            SHA256,
            scrypt
        };
        public static final CoinHash coinHash = CoinHash.scrypt;
        //Original Values
        public static final int TARGET_TIMESPAN = (int)(3.5 * 24 * 60 * 60); // EMC2: 3.5 days
        public static final int TARGET_SPACING = (int)(1 * 60);  // 1 minutes per block.

        public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  // 720 blocks

        public static final int getInterval(int height, boolean testNet) {

            return INTERVAL;
        }
        public static final int getTargetTimespan(int height, boolean testNet) {

            return TARGET_TIMESPAN;
        }
        public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
        public static final int MAX_MONEY = 299792458;                 //main.h:  MAX_MONEY
        public static final String MAX_MONEY_STRING = "299792458";     //main.h:  MAX_MONEY

        public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(100);   // MIN_TX_FEE
        public static final BigInteger DUST_LIMIT =      Utils.toNanoCoins("0.00100000"); //main.h DUST_SOFT_LIMIT        0.001 coins
        public static final BigInteger DUST_HARD_LIMIT = Utils.toNanoCoins("0.00001000"); //main.h DUST_HARD_LIMIT        0.00001 coins

        public static final int PROTOCOL_VERSION = 70002;          //version.h PROTOCOL_VERSION
        public static final int MIN_PROTOCOL_VERSION = 70002;        //version.h MIN_PROTO_VERSION

        public static final boolean supportsBloomFiltering = false; //Requires PROTOCOL_VERSION 70000 in the client

        public static final int Port    = 41878;       //protocol.h GetDefaultPort(testnet=false)
        public static final int TestPort = 31878;     //protocol.h GetDefaultPort(testnet=true)

        //
        //  Production
        //
        public static final int AddressHeader = 33;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
        public static final int p2shHeader = 5;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
        //public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
        public static final long PacketMagic = 0xe8f1c4ac;      //// EMC2: 7(lucky number) defaced.

        //Genesis Block Information from main.cpp: LoadBlockIndex
        static public long genesisBlockDifficultyTarget = 0x1e0ffff0L;         //main.cpp: LoadBlockIndex //block.nBits
        static public long genesisBlockTime = 1392841423L;                       //main.cpp: LoadBlockIndex
        static public long genesisBlockNonce = 3236648;                         //main.cpp: LoadBlockIndex //block.nNonce
        static public String genesisHash = "4e56204bb7b8ac06f860ff1c845f03f984303b5b97eb7b42868f714611aed94b"; //main.cpp: hashGenesisBlock
        static public int genesisBlockValue = 50;                                                              //main.cpp: LoadBlockIndex
        //taken from the raw data of the block explorer
        //TODO check this
        static public String genesisXInBytes = "04ffff001d01044c4c4e592054696d65732031392f4665622f32303134204e6f727468204b6f72656120417272657374732043687269737469616e204d697373696f6e6172792046726f6d204175737472616c6961";   //"5/9/2013 Aiden will be a year old in two months"
        static public String genessiXOutBytes = "76a9141cec44c9f9b769ae08ebf9d694c7611a16edf61588ac";

        //net.cpp strDNSSeed
        static public String[] dnsSeeds = new String[] {
                "dnsseed.einsteinium.org"
        };

        //
        // TestNet - EMC2 - not tested
        //
        public static final boolean supportsTestNet = true;
        public static final int testnetAddressHeader = 33;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
        public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
        public static final long testnetPacketMagic = 0x9defaced;      //0xfc, 0xc1, 0xb7, 0xdc
        public static final String testnetGenesisHash = "4e56204bb7b8ac06f860ff1c845f03f984303b5b97eb7b42868f714611aed94b";
        static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
        static public long testnetGenesisBlockTime = 1389306217L;                       //main.cpp: LoadBlockIndex
        static public long testnetGenesisBlockNonce = (11521194);                         //main.cpp: LoadBlockIndex



        public static int nDifficultySwitchHeight = 26754;     //main.cpp: GetNextWorkRequired //EMC2, use KGW


        public static final boolean usingNewDifficultyProtocol(int height)
        { return height >= nDifficultySwitchHeight;}



        //main.cpp GetBlockValue(height, fee)

        public static final BigInteger GetBlockReward(int height)
        {
            return Utils.toNanoCoins(50, 0).shiftRight(height / subsidyDecreaseBlockCount);
        }

        public static int subsidyDecreaseBlockCount = 840000;     //main.cpp GetBlockValue(height, fee)

        public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // Einsteinium: starting difficulty is 1 / 2^12

        static public String[] testnetDnsSeeds = new String[] {
                "not supported"
        };
        //from main.h: CAlert::CheckSignature
        public static final String SATOSHI_KEY = "04fc9702847840aaf195de8442ebecedf5b095cdbb9bc716bda9110971b28a49e0ead8564ff0db22209e0374782c093bb899692d524e9d6a6956e7c5ecbcd68284";
        public static final String TESTNET_SATOSHI_KEY = "04302390343f91cc401d56d68b123028bf52e5fca1939df127f63c6467cdf9c8e2c14b61104cf817d0b780da337893ecc4aaff1309e536162dabbdb45200ca2b0a";
        /** The string returned by getId() for the main, production network where people trade things. */
        public static final String ID_MAINNET = "org.einsteinium.production";
        /** The string returned by getId() for the testnet. */
        public static final String ID_TESTNET = "org.einsteinium.test";
        /** Unit test network. */
        public static final String ID_UNITTESTNET = "com.google.einsteinium.unittest";

        //checkpoints.cpp Checkpoints::mapCheckpoints
       /* public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
        {
            checkpoints.put( 0, new Sha256Hash("0x4d96a915f49d40b1e5c2844d1ee2dccb90013a990ccea12c492d22110489f0c4"));
            checkpoints.put( 24200, new Sha256Hash("0xd7ed819858011474c8b0cae4ad0b9bdbb745becc4c386bc22d1220cc5a4d1787"));
        }*/
}
