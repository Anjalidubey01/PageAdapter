package com.example.android.oxford_dictionary;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class model {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("word")
    @Expose
    private String word;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    public class Entry {

        @SerializedName("etymologies")
        @Expose
        private List<String> etymologies = null;

        public List<String> getEtymologies() {
            return etymologies;
        }

        public void setEtymologies(List<String> etymologies) {
            this.etymologies = etymologies;
        }

    }
    public class LexicalCategory {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("text")
        @Expose
        private String text;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }
    public class LexicalEntry {

        @SerializedName("entries")
        @Expose
        private List<Entry> entries = null;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("lexicalCategory")
        @Expose
        private LexicalCategory lexicalCategory;
        @SerializedName("text")
        @Expose
        private String text;

        public List<Entry> getEntries() {
            return entries;
        }

        public void setEntries(List<Entry> entries) {
            this.entries = entries;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public LexicalCategory getLexicalCategory() {
            return lexicalCategory;
        }

        public void setLexicalCategory(LexicalCategory lexicalCategory) {
            this.lexicalCategory = lexicalCategory;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }
    public class Metadata {

        @SerializedName("operation")
        @Expose
        private String operation;
        @SerializedName("provider")
        @Expose
        private String provider;
        @SerializedName("schema")
        @Expose
        private String schema;

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }

        public String getSchema() {
            return schema;
        }

        public void setSchema(String schema) {
            this.schema = schema;
        }

    }
    public class Result {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("lexicalEntries")
        @Expose
        private List<LexicalEntry> lexicalEntries = null;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("word")
        @Expose
        private String word;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public List<LexicalEntry> getLexicalEntries() {
            return lexicalEntries;
        }

        public void setLexicalEntries(List<LexicalEntry> lexicalEntries) {
            this.lexicalEntries = lexicalEntries;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

    }
}
